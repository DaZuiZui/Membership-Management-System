import request from '@/utils/request'

// 查询会员信息列表
export function listVipuser(query) {
  return request({
    url: '/system/vipuser/list',
    method: 'get',
    params: query
  })
}

// 查询会员信息详细
export function getVipuser(id) {
  return request({
    url: '/system/vipuser/' + id,
    method: 'get'
  })
}

// 新增会员信息
export function addVipuser(data) {
  return request({
    url: '/system/vipuser',
    method: 'post',
    data: data
  })
}

// 修改会员信息
export function updateVipuser(data) {
  return request({
    url: '/system/vipuser',
    method: 'put',
    data: data
  })
}

// 删除会员信息
export function delVipuser(id) {
  return request({
    url: '/system/vipuser/' + id,
    method: 'delete'
  })
}
